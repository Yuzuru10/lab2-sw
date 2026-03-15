## Project Structure
 
```
Lab2-sw-quality/
├── src/
│   ├── Criterion.java        # ISO 25023 metric — score calculation
│   ├── QualityDimension.java # ISO 25010 characteristic — weighted avg of criteria
│   ├── SWSystem.java         # Software system — report generation
│   ├── SWSystemData.java     # Factory class — test data (HashMap + ArrayList)
│   └── Main.java             # Entry point
└── README.md
```
## My Taken Notes While Working On This Task/Repo/Project Whatever you name it 
#### Criterion.java
```
    name of it - String
    importance - integer
    higher lower bs - could be an int or String (will do int 1 & 0)
    min & max acceptable values - float && [1,5]
    unit of it 🤓 - String/char
    measurement - float
    + already given calculate method/function whatever

```
#### Quality Dimension
```
    name - string 
    identifier - huh? iso code string ig
    weight - float per with criterion
    metric - higher || lower bs in criterion - int "Dynamically add new metric"? -> ArrayList then --> Hashmap to access it later , ok.
    Calling calculation in criterion
    + already given method for score calculation
    quality "score" comparison 

 ```
 #### pseudocode for Quality Dimension
 ```
    since dimension score = Σ(metricScore x metricWeight) / ΣWeights
    E.g.
     Criterion A -> score = 4.5, weight = 50
    Criterion B -> score = 3.5, weight = 40
    numerator = (4.5 x 50) + (3.5 x 40)
    denominator - 50 + 40
    result = numerator / denominator
 ```
#### SWSystem
```
    System name - string
    sys category - string
    sofware version - could be string again but float ? no actually can't do it like 1.1.1 if float
    multiple quality score - Array List again ???
    overall qscore - float - calculatios with thir weights ?? like ;
    (score1 x weight1) + (score2 x weight2) I assume
    qscore comparison get the min value - float
    qscore max - qscore min = gap - float
    reporting req - softsys - metric - values - scores - dimension socre - quality label - overall score - weakest and gap - let me sleep wtf
```
#### SWSystemData
```
    class-level method - static ethod to call, idk should be that
    sys conf & init ti everything?? no wait --> "SWSystemData.getAllSystems" -> actually should be in main
    system method - data category - hashmap
    what kind of name is shopsphere
    fricking iso print whatever
    set best values, ok 👍
    actually extensive refactoring time 🤓 thanks pdf
```    
#### Main
```
    SWSystemData.getAllSystems() thingy
    hashmap "web whatever thing"
    list loop 
    SetValue() section 5 on pdf
    and finally print report FFFFF
```
## Class Responsibilities
 
| Class | Responsibility |
|---|---|
| `Criterion` | Holds a single ISO 25023 metric. Normalizes measured value to a 1–5 score, rounded to 0.5. |
| `QualityDimension` | Holds multiple criteria. Calculates weighted average dimension score and quality label. |
| `SWSystem` | Holds multiple dimensions. Calculates overall score, finds weakest dimension, prints report. |
| `SWSystemData` | Static factory. Returns `HashMap<String, ArrayList<SWSystem>>` with pre-configured systems. |
 
## ISO/IEC 25023 Metric Reference
 
| ISO 25010 Characteristic | Metric | Direction | Unit | Formula |
|---|---|---|---|---|
| Functional Suitability | Functional Completeness Ratio | Higher | % | Implemented / Planned × 100 |
| Functional Suitability | Functional Correctness Ratio | Higher | % | Correct-output tests / Total tests × 100 |
| Reliability | Availability Ratio | Higher | % | Uptime / (Uptime + Downtime) × 100 |
| Reliability | Defect Density | Lower | defect/KLOC | Defects / 1000 LOC |
| Reliability | MTBF | Higher | hours | Total op time / Number of failures |
| Performance Efficiency | Response Time | Lower | ms | Avg end-to-end response time |
| Performance Efficiency | Throughput | Higher | req/s | Requests processed per second |
| Performance Efficiency | CPU Utilisation Ratio | Lower | % | CPU used / Total CPU × 100 |
| Usability | Task Completion Rate | Higher | % | Completed tasks / Total attempted × 100 |
| Usability | User Error Rate | Lower | % | Error ops / Total ops × 100 |
| Security | Security Test Coverage | Higher | % | Passed security tests / Total × 100 |
| Security | Vulnerability Count | Lower | count | Number of detected vulnerabilities |
| Maintainability | Test Coverage Ratio | Higher | % | Tested LOC / Total LOC × 100 |
| Maintainability | Cyclomatic Complexity (avg) | Lower | score | Avg cyclomatic complexity per module |
 
## Score Normalization
 
- **Higher is better:** `score = 1 + (value - min) / (max - min) × 4`
- **Lower is better:** `score = 5 - (value - min) / (max - min) × 4`
- Clamped to [1.0, 5.0], rounded to nearest 0.5
 
## Quality Labels
 
| Score | Label |
|---|---|
| 4.5 – 5.0 | Excellent Quality |
| 3.5 – 4.4 | Good Quality |
| 2.5 – 3.4 | Needs Improvement |
| 1.0 – 2.4 | Poor Quality |
 