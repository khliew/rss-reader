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

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;

public class FeedRequest extends Request<SyndFeed> {
    private final Response.Listener<SyndFeed> listener;

    public FeedRequest(String url, Response.Listener<SyndFeed> listener,
            Response.ErrorListener errorListener) {
        super(Request.Method.GET, url, errorListener);

        this.listener = listener;
    }

    @Override
    protected Response<SyndFeed> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException e) {
            parsed = new String(response.data);
        }

        try {
            SyndFeed feed = new SyndFeedInput().build(new StringReader(parsed));
            return Response.success(feed, HttpHeaderParser.parseCacheHeaders(response));
        } catch (FeedException e) {
            return Response.error(new ParseError(e));
        }
    }

    @Override
    protected void deliverResponse(SyndFeed response) {
        listener.onResponse(response);
    }
}
