import java.util.ArrayList;
public class QualityDimension{
    private String name;
    private float weight;
    private String isoCode;
    private ArrayList<Criterion> criteria;
    public QualityDimension(String name, String isoCode, float weight){
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteria = new ArrayList<>();
    }

    public void addCriterion(Criterion c){
        criteria.add(c);
    }

    public float CalculateDimension(){
        float dSum = 0;
        float dWeight = 0;
        for(Criterion c : criteria) {
            dSum += c.Calculate() * c.weight();
            dWeight += c.weight();
        }
        if(dWeight == 0) return 1.0f;
        float score = dSum / dWeight;
        return Math.round(score * 2.0f) / 2.0f;
    }

    public String IsoCode(){
        float score = CalculateDimension();
        if (score >= 4.5) return "Excellent Quality";
        if (score >= 3.5) return "Good Quality";
        if (score >= 2.5) return "Needs Improvement";
        return "Poor Quality";
    }

    public String name(){return name;}
    public String IsoName(){return isoCode;}
    public float weight(){return weight;}
    public ArrayList<Criterion> Criteria() {return criteria;}
}
