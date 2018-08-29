package ua.com.meraya;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ua.com.meraya.model.TokenInfo;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Application {

    public static void main(String[] args) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONObject data = (JSONObject) jsonParser.parse(new FileReader("./src/main/resources/enter.json"));
        JSONArray array = (JSONArray) data.get("tokens");

        ArrayList<TokenInfo> tokens = new ArrayList<>();
        for (Object o : array) {
            TokenInfo token = new TokenInfo();
            JSONObject object = (JSONObject) o;
            token.setBalance(new BigDecimal(Double.parseDouble(object.get("balance").toString())));
            JSONObject o1 = (JSONObject) object.get("tokenInfo");
            token.setFactor(Integer.parseInt(o1.get("decimals").toString()));
            token.setSymbol(o1.get("symbol").toString());
            if ((o1.get("price") instanceof JSONObject)) {
                JSONObject o2 = (JSONObject) o1.get("price");
                token.setRate(Double.parseDouble(o2.get("rate").toString()));
            }
            tokens.add(token);
        }

        tokens.sort(new Comparator<TokenInfo>() {
            @Override
            public int compare(TokenInfo o1, TokenInfo o2) {
                return Double.compare(o1.getRate(), o2.getRate());
            }
        });
        Collections.reverse(tokens);
        tokens.forEach(System.out::println);
    }
}
