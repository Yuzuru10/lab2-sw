import java.util.ArrayList;
public class SWSystem {
    private String name;
    private String category;
    private String version;
    private ArrayList<QualityDimension> dimensions;

    public SWSystem(String name, String category, String version){
        this.name = name;
        this.category = category;
        this.version = version;
        this.dimensions = new ArrayList<>();
    }

    public void addDimension(QualityDimension d){
        dimensions.add(d);
    }

    public float OverallScore(){
        float dSum = 0;
        float dWeight =0;
        for(QualityDimension d : dimensions){
            dSum += d.CalculateDimension() * d.weight();
            dWeight += d.weight();
        }
        if(dWeight == 0) return 1.0f;
        float score = dSum / dWeight;
        return Math.round(score * 10.0f ) / 10.0f;
    }

    public QualityDimension Dimension(){
        QualityDimension min = null;
        float lowmin = Float.MAX_VALUE;
        for(QualityDimension d : dimensions){
            if(d.CalculateDimension() < lowmin){
                lowmin = d.CalculateDimension();
                min = d;
            }
        }
        return min;
    }
    public String QualityLabel(float score) {
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    public void printReport() {
        System.out.println("========================================");
        System.out.println("SOFTWARE QUALITY REPORT (ISO/IEC 25010)");
        System.out.printf("System: %s v%s (%s)%n", name, version, category);
        System.out.println("========================================");

        for(QualityDimension d : dimensions){
            System.out.printf("%n--- %s [%s] (Weight: %.0f) ---%n", d.name(), d.IsoName(), d.weight());
            for(Criterion c : d.Criteria()){
                String direction = c.direction() == 1 ? "Higher is better" : "Lower is better";
                System.out.printf("%s: %.1f %s -> Score: %.1f (%s)%n",
                        c.name(), c.value(), c.unit(), c.Calculate(), direction);
            }
            System.out.printf(">> Dimension Score: %.1f/5 [%s]%n",
                    d.CalculateDimension(), d.IsoCode());
        }
        float overall = OverallScore();
        System.out.println("\n========================================");
        System.out.printf("OVERALL QUALITY SCORE: %.1f/5 [%s]%n", overall, QualityLabel(overall));
        System.out.println("========================================");

        QualityDimension min = Dimension();
        System.out.println("GAP ANALYSIS (ISO/IEC 25010)");
        System.out.println("========================================");
        if (min != null) {
            System.out.printf("Weakest Characteristic : %s [%s]%n", min.name(), min.IsoName());
            System.out.printf("Score: %.1f/5 | Gap: %.1f%n",
                    min.CalculateDimension(), min.QualityGap());
            System.out.printf("Level: %s%n", min.IsoCode());
            System.out.println(">> This characteristic requires the most improvement.");
        }
        System.out.println("========================================");
    }

    public String name(){return name;}
    public String category(){return category;}
    public String version(){return version;}
    public ArrayList<QualityDimension> dimensions() {return dimensions;
    }
}
