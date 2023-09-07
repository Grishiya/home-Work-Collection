package sky.pro.homeworkcollection.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalNameException extends IllegalArgumentException {
    public IllegalNameException() {
    }

    public IllegalNameException(String s) {
        super(s);
    }

    public IllegalNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalNameException(Throwable cause) {
        super(cause);
    }
}
