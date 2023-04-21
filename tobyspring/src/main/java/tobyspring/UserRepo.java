package tobyspring;

import org.springframework.stereotype.Component;

@Component
public class UserRepo  implements UserService {

    @Override
    public String getUserType(){

        return "student";
    }

}
