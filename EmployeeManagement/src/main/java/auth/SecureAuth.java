/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package auth;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import record.KeepRecord;

/**
 *
 * @author Maitrayee
 */
@RequestScoped
public class SecureAuth implements HttpAuthenticationMechanism, Serializable {

    @Inject
    IdentityStoreHandler identityStoreHandler;

    CredentialValidationResult credentialValidationResult;

    AuthenticationStatus status;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext context) throws AuthenticationException {
        try {
            if (request.getParameter("username") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");

                Credential credential = new UsernamePasswordCredential(username, new Password(password));
//                Pbkdf2PasswordHashImpl pb = new Pbkdf2PasswordHashImpl();
//                System.out.println(pb.generate("mili123".toCharArray()));
                credentialValidationResult = identityStoreHandler.validate(credential);

                if (credentialValidationResult.getStatus() == CredentialValidationResult.Status.VALID) {
                    KeepRecord.setErrorStatus("");
                    KeepRecord.setPrincipal(credentialValidationResult.getCallerPrincipal());
                    KeepRecord.setRoles(credentialValidationResult.getCallerGroups());
                    KeepRecord.setCredential(credential);

                    status = context.notifyContainerAboutLogin(credentialValidationResult);

                    if (credentialValidationResult.getCallerGroups().contains("admin")) {
                        request.getRequestDispatcher("admin/Admin.jsf").forward(request, response);
                    }
                    if (credentialValidationResult.getCallerGroups().contains("user")) {
                        request.getRequestDispatcher("user/User.jsf").forward(request, response);
                    }

                    return status;
                } else {
                    KeepRecord.setErrorStatus("Either Username or Password is wrong !");
                    response.sendRedirect("Login.jsf");
                    return context.doNothing();
                }

            }

            if (KeepRecord.getPrincipal() != null) {
                credentialValidationResult = identityStoreHandler.validate(KeepRecord.getCredential());

                if (request.getRequestURI().contains("admin") && credentialValidationResult.getCallerGroups().contains("user")) {
                    context.responseUnauthorized();
                } else if (request.getRequestURI().contains("user") && credentialValidationResult.getCallerGroups().contains("admin")) {
                    context.responseUnauthorized();
                }

                context.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return context.doNothing();
    }
}
