import java.util.Map;
import java.util.HashMap;

public class DialingCodes {

    private final Map<Integer, String> codesMap = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return codesMap;
    }

    public void setDialingCode(Integer code, String country) {
        codesMap.put(code, country);
    }

    public String getCountry(Integer code) {
        return codesMap.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!codesMap.containsKey(code) && !codesMap.containsValue(country)) {
            codesMap.put(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        Integer foundCode = null;

        for (Integer code : codesMap.keySet()) {
            if (codesMap.get(code).equals(country)) {
                foundCode = code;
                break;
            }
        }

        return foundCode;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer foundCode = findDialingCode(country);

        if (foundCode != null) {
            codesMap.remove(foundCode);
            setDialingCode(code, country);
        }
    }
}
