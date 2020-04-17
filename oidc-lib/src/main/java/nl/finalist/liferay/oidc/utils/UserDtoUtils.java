package nl.finalist.liferay.oidc.utils;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.StringPool;
import nl.finalist.liferay.oidc.dto.UserDto;
import nl.finalist.liferay.oidc.providers.UserInfoProvider;

import java.util.Calendar;
import java.util.Map;

public class UserDtoUtils {

    private UserDtoUtils() {
        throw new IllegalStateException("Утилитный класс");
    }

    public static UserDto generateNew(Map<String, Object> userInfo, UserInfoProvider provider) {
        final String password1 = PwdGenerator.getPassword();

        final UserDto userDto = new UserDto();
        userDto.setUuid(provider.getUuid(userInfo));
        userDto.setAutoScreenName(true);
        userDto.setScreenName("not_used_but_autogenerated_instead");
        userDto.setPrefixId(0);
        userDto.setSuffixId(0);
        userDto.setBirthdayDay(1);
        userDto.setBirthdayMonth(Calendar.JANUARY);
        userDto.setBirthdayYear(1970);
        userDto.setJobTitle(StringPool.BLANK);
        userDto.setFacebookId(0);
        userDto.setOpenId(StringPool.BLANK);
        userDto.setLocale(LocaleUtil.getMostRelevantLocale());
        userDto.setCreatorUserId(0);
        userDto.setAutoPassword(false);
        userDto.setPassword1(password1);
        userDto.setPassword2(password1);
        userDto.setSendEmail(false);
        userDto.setEmail(provider.getEmail(userInfo));
        userDto.setFirstName(provider.getFirstName(userInfo));
        userDto.setLastName(provider.getLastName(userInfo));
        userDto.setMiddleName(provider.getMiddleName(userInfo));
        userDto.setMale(true);
        userDto.setGroupIds(null);
        userDto.setRoleIds(null);
        userDto.setUserGroupIds(provider.getUserGroupIds(userInfo));
        userDto.setOrganizationIds(null);
        userDto.setPasswordReset(false);
        userDto.setQueryQuestion("Secret question");
        userDto.setQueryAnswer(PwdGenerator.getPassword());
        return userDto;
    }

}
