import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

public class TestAdCats {

    public static void main(String[] args) {
        Ad ad = new Ad(34, 1, "The Boss", "Stuff", "12/26/1997");

        DaoFactory.getAdsDao().getCatNamesByAdId(ad);
        System.out.println(ad.getCategories());

    }
}
