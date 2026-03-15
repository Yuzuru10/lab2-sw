public class Criterion {
    private String name;
    private float weight;
    private int direction; // 1 is higher criteria
    private float min;
    private float max;
    private String unit;
    private float measuredvalue;
    private boolean isSet = false;

    public Criterion(String name, float weight, int direction, float min, float max, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.min = min;
        this.max = max;
        this.unit = unit;

    }
    public void isSet(float measuredvalue){
        this.measuredvalue = measuredvalue;
        this.isSet = true;
    }

    public float Calculate(){

        if(!isSet ){
            return 1.00f;
        }
        float score;
        if (direction == 1){
            score = 1 + (measuredvalue - min) / (max - min) * 4;
        }else{
            score = 5 - (measuredvalue - min) / (max - min) * 4;
        }
        score = Math.max(1.0f, Math.min(5.0f, score));
        //math.max prints the max isSet between 1 and the other one to clip it to minimum isSet of 1 and math.min does the exact opposite for clipping it to 5 if isSet is bigger than 5
        return Math.round(score*2)/2.0f;
        //idk but it works
    }
    public String name(){return name;}
    public float weight(){return weight;}
    public int direction(){return direction;}
    public String unit(){return unit;}
    public float measuredvalue(){return measuredvalue;}
}