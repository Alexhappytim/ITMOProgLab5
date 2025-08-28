package common.network;

import common.dragon.Dragon;

import java.io.Serializable;
import java.util.Map;
import java.util.PriorityQueue;

public class Response implements Serializable {
    public static final Integer OK = 0;
    public static final Integer WRONGLOGIN = 1;
    public static final Integer NOTLOGINED = 2;
    public static final Integer UNKNOWNERROR = 3;
    public static final Integer ALREADYEXIST = 4;
    public static final Integer NOSUCHELEMENT = 5;
    public static final Integer EMPTYCOLLECTION = 6;
    private static final long serialVersionUID = 161422385121824689L;
    private String response;
    private Integer statusCode;
    private PriorityQueue<Dragon> collection;
    private Map<Long, String> ownershipMap;
    public Response(String response, Integer statusCode){
        this.response = response;
        this.statusCode = statusCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public PriorityQueue<Dragon> getCollection() {
        return collection;
    }

    public void setCollection(PriorityQueue<Dragon> collection) {
        this.collection = collection;
    }

    public Map<Long, String> getOwnershipMap() {
        return ownershipMap;
    }

    public void setOwnershipMap(Map<Long, String> ownershipMap) {
        this.ownershipMap = ownershipMap;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
