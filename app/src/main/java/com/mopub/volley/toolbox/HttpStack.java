package com.mopub.volley.toolbox;

import com.mopub.volley.Request;
import java.util.Map;
import org.apache.http.HttpResponse;

public interface HttpStack {
   HttpResponse performRequest(Request var1, Map var2);
}
