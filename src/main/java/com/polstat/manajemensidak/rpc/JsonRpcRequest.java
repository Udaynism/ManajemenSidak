package com.polstat.manajemensidak.rpc;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

@Data
public class JsonRpcRequest {
    private String jsonrpc;
    private String method;
    private JsonNode params;
    private String id;
}
