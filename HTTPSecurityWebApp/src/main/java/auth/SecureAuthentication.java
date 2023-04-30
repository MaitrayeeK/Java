/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package auth;

import bean.LoginJSFManagedBean;
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
import javax.security.enterprise.identitystore.CredentialValidationResult.Status;
import javax.security.enterprise.identitystore.IdentityStoreHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import record.KeepRecord;

/**
 *
 * @author Maitrayee
 */
@RequestScoped
public class SecureAuthentication implements HttpAuthenticationMechanism, Serializable{
    
    @Inject
    IdentityStoreHandler identity;
    CredentialValidationResult result;
    AuthenticationStatus status;
    LoginJSFManagedBean loginbean;

    @Override
    public AuthenticationStatus validateRequest(HttpServletRequest request, HttpServletResponse response, HttpMessageContext hmc) throws AuthenticationException {
        try {
            if (request.getParameter("username") != null && request.getParameter("password") != null) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                
                Credential credential = new UsernamePasswordCredential(username, new Password(password));
                result = identity.validate(credential);
                
                if(result.getStatus() == Status.VALID) {
                    KeepRecord.setErrorstatus("");
                    
                    status = hmc.notifyContainerAboutLogin(result);
                    
                    KeepRecord.setPrincipal(result.getCallerPrincipal());
                    KeepRecord.setRoles(result.getCallerGroups());
                    KeepRecord.setCredential(credential);
                    
                    if(result.getCallerGroups().contains("Admin")) {
                        response.sendRedirect("admin.jsf");
                    }
                    
                    if(result.getCallerGroups().contains("Supervisor")) {
                        response.sendRedirect("user.jsf");
                    }
                    
                    return status;
                }
                else {
                    KeepRecord.setErrorstatus("Username or password is wrong");
                    response.sendRedirect("login.jsf");
                    return hmc.doNothing();
                }
            }
            
            if(KeepRecord.getPrincipal() != null) {
                result = identity.validate(KeepRecord.getCredential());
                
                if(result.getCallerGroups().contains("Admin") && request.getRequestURI().contains("Supervisor")) {
                    hmc.responseUnauthorized();
                } else if(result.getCallerGroups().contains("Supervisor") && request.getRequestURI().contains("Admin")) {
                    hmc.responseUnauthorized();
                }
                
                hmc.notifyContainerAboutLogin(KeepRecord.getPrincipal(), KeepRecord.getRoles());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hmc.doNothing();
    }

}
