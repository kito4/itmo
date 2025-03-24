package com.kito.server.utils;



import com.kito.server.entities.HumanBeing;
import org.xml.sax.SAXException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;



public class HumanValidator {

    static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    static Validator validator = validatorFactory.getValidator();
    public static boolean validateHuman(HumanBeing human) throws IOException, SAXException {
        Set<ConstraintViolation<HumanBeing>> validateResult = validator.validate(human);
        if (validateResult.size() > 0) {
            for (ConstraintViolation<HumanBeing> violation : validateResult) {
                TextSender.printError(violation.getPropertyPath() + " " + violation.getMessage());
            }
            return false;
        }
        return true;
    }

    public static <T> boolean validateField(T t, String fieldName) {
        Set<ConstraintViolation<T>> validateResult = validator.validateProperty(t, fieldName);
        if (validateResult.size() > 0) {
            for (ConstraintViolation<T> violation : validateResult) {
                TextSender.printError(violation.getPropertyPath() + " " + violation.getMessage());
            }
            return false;
        }
        return true;
    }
}
