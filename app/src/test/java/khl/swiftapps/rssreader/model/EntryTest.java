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
import com.rometools.rome.feed.synd.SyndContent;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndLink;
import com.rometools.rome.feed.synd.SyndPerson;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Date;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class EntryTest {
    public static final String URI = "uri";
    public static final String TITLE = "title";
    public static final String LINK_URL = "linkUrl";
    public static final String DESCRIPTION = "description";
    public static final Date PUBLISHED_DATE = new Date();
    public static final Date UPDATED_DATE = new Date();
    public static final String AUTHOR_NAME = "authorName";
    public static final String CONTRIBUTOR_NAME = "contributorName";
    public static final String CATEGORY_NAME = "categoryName";
    public static final String COMMENTS_URL = "commentsUrl";

    @Test
    public void createEntry_fromSyndEntry_hasUri() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndEntry.getUri()).thenReturn(URI);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getUri(), is(URI));
    }

    @Test
    public void createEntry_fromSyndEntry_hasTitle() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndEntry.getTitle()).thenReturn(TITLE);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getTitle(), is(TITLE));
    }

    @Test
    public void createEntry_fromSyndEntry_hasLinks() {
        SyndLink syndLink = Mockito.mock(SyndLink.class);
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndLink.getHref()).thenReturn(LINK_URL);
        when(syndEntry.getLinks()).thenReturn(Collections.singletonList(syndLink));

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getLinks(), hasItem(LINK_URL));
    }

    @Test
    public void createEntry_fromSyndEntry_hasDescription() {
        SyndContent syndContent = Mockito.mock(SyndContent.class);
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndContent.getValue()).thenReturn(DESCRIPTION);
        when(syndEntry.getDescription()).thenReturn(syndContent);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getDescription(), is(DESCRIPTION));
    }

    @Test
    public void createEntry_fromSyndEntry_hasPublishedDate() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndEntry.getPublishedDate()).thenReturn(PUBLISHED_DATE);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getPublishedDate(), is(PUBLISHED_DATE));
    }

    @Test
    public void createEntry_fromSyndEntry_hasUpdatedDate() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndEntry.getUpdatedDate()).thenReturn(UPDATED_DATE);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getUpdatedDate(), is(UPDATED_DATE));
    }

    @Test
    public void createEntry_fromSyndEntry_hasAuthors() {
        SyndPerson syndPerson = Mockito.mock(SyndPerson.class);
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndPerson.getName()).thenReturn(AUTHOR_NAME);
        when(syndEntry.getAuthors()).thenReturn(Collections.singletonList(syndPerson));

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getAuthors(), hasItem(AUTHOR_NAME));
    }

    @Test
    public void createEntry_fromSyndEntry_hasContributors() {
        SyndPerson syndPerson = Mockito.mock(SyndPerson.class);
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndPerson.getName()).thenReturn(CONTRIBUTOR_NAME);
        when(syndEntry.getContributors()).thenReturn(Collections.singletonList(syndPerson));

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getContributors(), hasItem(CONTRIBUTOR_NAME));
    }

    @Test
    public void createEntry_fromSyndEntry_hasCategories() {
        SyndCategory syndCategory = Mockito.mock(SyndCategory.class);
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndCategory.getName()).thenReturn(CATEGORY_NAME);
        when(syndEntry.getCategories()).thenReturn(Collections.singletonList(syndCategory));

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getCategories(), hasItem(CATEGORY_NAME));
    }

    @Test
    public void createEntry_fromSyndEntry_hasCommentsUrl() {
        SyndEntry syndEntry = Mockito.mock(SyndEntry.class);
        when(syndEntry.getComments()).thenReturn(COMMENTS_URL);

        Entry entry = new Entry(syndEntry);

        assertThat(entry.getCommentsUrl(), is(COMMENTS_URL));
    }
}
