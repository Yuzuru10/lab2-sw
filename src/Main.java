import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();
        ArrayList<SWSystem> webSystems = allSystems.get("Web");

        SWSystem shopSphere = null;
        for (SWSystem sys : webSystems) {
            if (sys.name().equals("ShopSphere")) {
                shopSphere = sys;
                break;
            }
        }

        if (shopSphere == null) {
            System.out.println("ShopSphere not found.");
            return;
        }

        ArrayList<QualityDimension> dims = shopSphere.dimensions();

        dims.get(0).Criteria().get(0).isSet(94.0f);
        dims.get(0).Criteria().get(1).isSet(91.0f);

        dims.get(1).Criteria().get(0).isSet(99.2f);
        dims.get(1).Criteria().get(1).isSet(2.1f);

        dims.get(2).Criteria().get(0).isSet(220.0f);
        dims.get(2).Criteria().get(1).isSet(38.0f);

        dims.get(3).Criteria().get(0).isSet(72.0f);
        dims.get(3).Criteria().get(1).isSet(8.5f);

        shopSphere.printReport();
    }
}