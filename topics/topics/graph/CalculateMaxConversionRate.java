package graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateMaxConversionRate {
    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        Map<String, Double> mapCurrencyToPrice = new HashMap<>();

        mapCurrencyToPrice.put(initialCurrency, 1.0);
        calculateMax(pairs1, rates1, mapCurrencyToPrice);
        calculateMax(pairs2, rates2, mapCurrencyToPrice);
        return mapCurrencyToPrice.get(initialCurrency);
    }

    public void calculateMax(List<List<String>> pairs, double[] rates, Map<String, Double> map)
    {
        for(int r = 0; r< pairs.size(); r++)
        {
            for(int i=0;i<pairs.size();i++)
            {
                String from = pairs.get(i).get(0);
                String to = pairs.get(i).get(1);
                double rate = rates[i];
                double fromDist = map.get(from)==null ? 0: map.get(from);
                double toDist = map.get(to) == null ? 0: map.get(to);
                map.put(to, Double.max(toDist, fromDist*rate));
                map.put(from, Double.max(fromDist, map.get(to)*(1/rate)));

            }
        }

    }

    public static void main(String[] args) {
        CalculateMaxConversionRate calculateMaxConversionRate = new CalculateMaxConversionRate();

    }
}
