package reger.jcaptcha;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * jcaptcha service singleton
 */

public class CaptchaServiceSingleton {

    private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();

    public static ImageCaptchaService getInstance(){
        return instance;
    }
}
