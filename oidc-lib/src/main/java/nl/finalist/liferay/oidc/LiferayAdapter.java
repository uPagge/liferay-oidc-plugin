package nl.finalist.liferay.oidc;

import nl.finalist.liferay.oidc.dto.UserDto;

import javax.servlet.http.HttpServletRequest;


public interface LiferayAdapter {

    OIDCConfiguration getOIDCConfiguration(long companyId);
    
    void trace(String s);
    void info(String s);
    void debug(String s);
    void warn(String s);
    void error(String s);

    String getCurrentCompleteURL(HttpServletRequest request);

    boolean isUserLoggedIn(HttpServletRequest request);

    long getCompanyId(HttpServletRequest request);

    /**
     * Create user or update if already existing. Keys to base existance on are: companyId, emailAddress.
     * GivenName and familyName are used for setting the according fields.
     *
     * @param companyId the virtual instance id
     * @return the userId of the created or updated User, as a String
     */
    String createOrUpdateUser(long companyId, UserDto userDto);

}
