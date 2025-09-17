package Proxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AccessControlService {
    private static AccessControlService accessControlService;
    private final HashMap<String, List<Integer>> accessMap;

    private AccessControlService() {
        accessMap = new HashMap<>();
        accessMap.put("user1", new ArrayList<>(Arrays.asList(1, 2, 3)));
        accessMap.put("user2", new ArrayList<>(Arrays.asList(4, 5)));
    }

    public static AccessControlService getAccessControlService() {
        if (accessControlService == null) {
            return new AccessControlService();
        } else {
            return accessControlService;
        }
    }

    public boolean hasAccess(String username, int docId) {
        if (accessMap.containsKey(username) && accessMap.get(username).contains(docId)) {
            return true;
        } else {
            return false;
        }
    }
}
