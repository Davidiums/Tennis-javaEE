package dao.Interfaces;

import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

public abstract class JsonFactory {

    public static void successReturn(HttpServletResponse response){
        // Créer un objet JSON contenant le résultat de la modification
        JSONObject result = new JSONObject();
        try {
            result.put("updated", true);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        // Envoyer l'objet JSON dans le corps de la réponse HTTP
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String convertListToJson(List<Object> objects) {
        JSONArray jsonArray = new JSONArray(objects);
        return jsonArray.toString();
    }


}
