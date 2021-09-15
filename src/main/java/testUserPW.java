import com.codeup.adlister.util.Password;

public class testUserPW {

    public static void main(String[] args) {
        String pw = Password.hash("codeup");
        System.out.println(pw);
    }
}
