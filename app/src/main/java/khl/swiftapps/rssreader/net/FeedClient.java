/*
 * Copyright 2017 Kenny Liew
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package khl.swiftapps.rssreader.net;

import android.content.Context;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.rometools.rome.feed.synd.SyndFeed;

import khl.swiftapps.rssreader.BuildConfig;
import khl.swiftapps.rssreader.model.Feed;

public class FeedClient {
    private static final String TAG = FeedClient.class.getSimpleName();

    public static final int STATUS_OK = -1;
    public static final int STATUS_ERROR = 0;

    private static FeedClient sInstance;

    private RequestQueue mQueue;

    public static synchronized FeedClient getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new FeedClient(context);
        }
        return sInstance;
    }

    private FeedClient(Context context) {
        mQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public void getFeed(String url, final Listener listener) {
        FeedRequest request = new FeedRequest(url, new Response.Listener<SyndFeed>() {
            @Override
            public void onResponse(SyndFeed response) {
                listener.onResponse(STATUS_OK, new Feed(response));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                log("onErrorResponse: error=" + error.getMessage());
                listener.onResponse(STATUS_ERROR, null);
            }
        });

        mQueue.add(request);
    }

    public interface Listener {
        void onResponse(int status, Feed feed);
    }

    private static void log(String msg) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, msg);
        }
    }
}
