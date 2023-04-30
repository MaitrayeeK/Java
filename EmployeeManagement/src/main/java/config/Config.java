/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package config;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author Maitrayee
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "jnd/myresource",
        callerQuery = "select password from employeetb where email=?",
        groupsQuery = "select groupname from groupmaster where username=?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30
)
@ApplicationScoped
public class Config {
    
}
