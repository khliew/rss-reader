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

package khl.swiftapps.rssreader.model;

import com.rometools.rome.feed.synd.SyndCategory;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndImage;
import com.rometools.rome.feed.synd.SyndPerson;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class FeedTest {
    public static final String TYPE = "type";
    public static final String ENCODING = "encoding";
    public static final String URI = "uri";
    public static final String TITLE = "title";
    public static final String LINK_URL = "linkUrl";
    public static final String DESCRIPTION = "description";
    public static final Date PUBLISHED_DATE = new Date();
    public static final String AUTHOR_NAME = "authorName";
    public static final String CONTRIBUTOR_NAME = "contributorName";
    public static final String COPYRIGHT = "copyright";
    public static final String IMAGE_URL = "imageUrl";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String ENTRY_TITLE = "entryTitle";
    public static final String LANGUAGE = "language";
    public static final String WEB_MASTER = "webMaster";

    @Test
    public void createFeed_fromSyndFeed_hasType() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getFeedType()).thenReturn(TYPE);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getType(), is(TYPE));
    }

    @Test
    public void createFeed_fromSyndFeed_hasEncoding() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getEncoding()).thenReturn(ENCODING);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getEncoding(), is(ENCODING));
    }

    @Test
    public void createFeed_fromSyndFeed_hasUri() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getUri()).thenReturn(URI);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getUri(), is(URI));
    }

    @Test
    public void createFeed_fromSyndFeed_hasTitle() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getTitle()).thenReturn(TITLE);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getTitle(), is(TITLE));
    }

    @Test
    public void createFeed_fromSyndFeed_hasLinks() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getLink()).thenReturn(LINK_URL);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getLink(), is(LINK_URL));
    }

    @Test
    public void createFeed_fromSyndFeed_hasDescription() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getDescription()).thenReturn(DESCRIPTION);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getDescription(), is(DESCRIPTION));
    }

    @Test
    public void createFeed_fromSyndFeed_hasPublishedDate() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getPublishedDate()).thenReturn(PUBLISHED_DATE);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getPublishedDate(), is(PUBLISHED_DATE));
    }

    @Test
    public void createFeed_fromSyndFeed_hasAuthors() {
        SyndPerson syndPerson = Mockito.mock(SyndPerson.class);
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndPerson.getName()).thenReturn(AUTHOR_NAME);
        when(syndFeed.getAuthors()).thenReturn(Collections.singletonList(syndPerson));

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getAuthors(), hasItem(AUTHOR_NAME));
    }

    @Test
    public void createFeed_fromSyndFeed_hasContributors() {
        SyndPerson syndPerson = Mockito.mock(SyndPerson.class);
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndPerson.getName()).thenReturn(CONTRIBUTOR_NAME);
        when(syndFeed.getContributors()).thenReturn(Collections.singletonList(syndPerson));

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getContributors(), hasItem(CONTRIBUTOR_NAME));
    }

    @Test
    public void createFeed_fromSyndFeed_hasCopyright() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getCopyright()).thenReturn(COPYRIGHT);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getCopyright(), is(COPYRIGHT));
    }

    @Test
    public void createFeed_fromSyndFeed_hasImageUrl() {
        SyndImage syndImage = Mockito.mock(SyndImage.class);
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndImage.getUrl()).thenReturn(IMAGE_URL);
        when(syndFeed.getImage()).thenReturn(syndImage);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getImageUrl(), is(IMAGE_URL));
    }

    @Test
    public void createFeed_fromSyndFeed_hasCategories() {
        SyndCategory syndCategory = Mockito.mock(SyndCategory.class);
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndCategory.getName()).thenReturn(CATEGORY_NAME);
        when(syndFeed.getCategories()).thenReturn(Collections.singletonList(syndCategory));

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getCategories(), hasItem(CATEGORY_NAME));
    }

    @Test
    public void createFeed_fromSyndFeed_hasEntries() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndEntry.getTitle()).thenReturn(ENTRY_TITLE);
        when(syndFeed.getEntries()).thenReturn(Collections.singletonList(syndEntry));

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getEntries().get(0).getTitle(), is(ENTRY_TITLE));
    }

    @Test
    public void createFeed_fromSyndFeed_hasLanguage() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getLanguage()).thenReturn(LANGUAGE);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getLanguage(), is(LANGUAGE));
    }

    @Test
    public void createFeed_fromSyndFeed_hasWebMaster() {
        SyndFeed syndFeed = Mockito.mock(SyndFeed.class);
        when(syndFeed.getWebMaster()).thenReturn(WEB_MASTER);

        Feed feed = new Feed(syndFeed);

        assertThat(feed.getWebMaster(), is(WEB_MASTER));
    }
}
