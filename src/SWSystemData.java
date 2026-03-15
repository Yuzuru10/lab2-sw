import java.util.ArrayList;
import java.util.HashMap;

public class SWSystemData {

    public static HashMap<String, ArrayList<SWSystem>> getAllSystems() {
        HashMap<String, ArrayList<SWSystem>> map = new HashMap<>();

        // Create Web systems - im gonna refactor that set example quite extensively 🤓☝
        ArrayList<SWSystem> webList = new ArrayList<>();
        webList.add(createECommercePlatform());
        webList.add(createBankingPortal());
        map.put("Web", webList);

        // Create Mobile systems
        ArrayList<SWSystem> mobileList = new ArrayList<>();
        mobileList.add(createHealthApp());
        map.put("Mobile", mobileList);

        return map;
    }

    private static SWSystem createECommercePlatform() {
        // My imaginary best shop ShopSphere ❤
        SWSystem s = new SWSystem("ShopSphere", "Web", "3.2.1");

        // ISO 25010: Functional Suitability (QC.FS) --- ISO 25023 metrics
        QualityDimension funcSuit = new QualityDimension("Functional Suitability", "QC.FS", 25);

        funcSuit.addCriterion(new Criterion("Functional Completeness Ratio",50, 1, 0, 100, "%"));
        // ISO 25023 metric name
        // Implemented / Planned × 100

        funcSuit.addCriterion(new Criterion("Functional Correctness Ratio", 50, 1, 0, 100, "%"));
        // Correct-output tests / Total tests × 100

        s.addDimension(funcSuit);

        // ISO 25010: Reliability (QC.RE) --- ISO 25023 metrics
        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 25);

        reliability.addCriterion(new Criterion("Availability Ratio", 50, 1, 95, 100, "%"));
        // Uptime / (Uptime + Downtime) × 100

        reliability.addCriterion(new Criterion("Defect Density", 50, 0, 0, 20, "defect/KLOC"));
        // Defects found / 1000 LOC

        s.addDimension(reliability);

        // ... add remaining quality characteristics - fine.

        QualityDimension perf = new QualityDimension("Performance Efficiency", "QC.PE", 25);
        perf.addCriterion(new Criterion("Response Time",       50, 0,   0, 500, "ms"));
        perf.addCriterion(new Criterion("CPU Utilisation",     50, 0,   0, 100, "%"));
        s.addDimension(perf);

        QualityDimension maint = new QualityDimension("Maintainability", "QC.MA", 25);
        maint.addCriterion(new Criterion("Test Coverage Ratio",         50, 1,  0, 100, "%"));
        maint.addCriterion(new Criterion("Cyclomatic Complexity",       50, 0,   1,  20, "score"));
        s.addDimension(maint);

        //ctrl + c , ctrl + v ,my best friends

        return s;
    }

    // ... implement createBankingPortal() and createHealthApp() - alr pookie.

    private static SWSystem createBankingPortal() {
        //My imaginary go to bank
        SWSystem s = new SWSystem("SecureBank Portal", "Web", "2.0.4");

        QualityDimension security = new QualityDimension("Security", "QC.SE", 40);
        security.addCriterion(new Criterion("Security Test Coverage", 60, 1,  0, 100, "%"));
        security.addCriterion(new Criterion("Vulnerability Count",    40, 0,   0,  50, "count"));
        s.addDimension(security);

        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 30);
        reliability.addCriterion(new Criterion("Availability Ratio", 50, 1, 95, 100, "%"));
        reliability.addCriterion(new Criterion("MTBF",               50, 1,  0, 2000, "hours"));
        s.addDimension(reliability);

        QualityDimension maint = new QualityDimension("Maintainability", "QC.MA", 30);
        maint.addCriterion(new Criterion("Test Coverage Ratio",   50, 1,  0, 100, "%"));
        maint.addCriterion(new Criterion("Cyclomatic Complexity", 50, 0,   1,  20, "score"));
        s.addDimension(maint);

        return s;
    }

    private static SWSystem createHealthApp() {
        SWSystem s = new SWSystem("VitalTrack", "Mobile", "1.4.0");

        QualityDimension usability = new QualityDimension("Usability", "QC.US", 35);
        usability.addCriterion(new Criterion("Task Completion Rate", 50, 1,  0, 100, "%"));
        usability.addCriterion(new Criterion("User Error Rate",      50, 0,   0,  50, "%"));
        s.addDimension(usability);

        QualityDimension perf = new QualityDimension("Performance Efficiency", "QC.PE", 35);
        perf.addCriterion(new Criterion("Response Time",   50, 0,   0, 500, "ms"));
        perf.addCriterion(new Criterion("Throughput",      50, 1,  0, 200, "req/s"));
        s.addDimension(perf);

        QualityDimension reliability = new QualityDimension("Reliability", "QC.RE", 30);
        reliability.addCriterion(new Criterion("Availability Ratio", 50, 1, 95, 100, "%"));
        reliability.addCriterion(new Criterion("Defect Density",     50, 0,   0,  20, "defect/KLOC"));
        s.addDimension(reliability);

        return s;
    }
}
