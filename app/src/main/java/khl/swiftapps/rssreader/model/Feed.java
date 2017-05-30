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
import com.rometools.rome.feed.synd.SyndPerson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Feed {
    private String type;
    private String encoding;
    private String uri;
    private String title;
    private String link;
    private String description;
    private Date publishedDate;
    private List<String> authors;
    private List<String> contributors;
    private String copyright;
    private String imageUrl;
    private List<String> categories;
    private List<Entry> entries;
    private String language;
    private String webMaster;

    public Feed() {
        // do nothing
    }

    public Feed(SyndFeed sf) {
        this.type = sf.getFeedType();
        this.encoding = sf.getEncoding();
        this.uri = sf.getUri();
        this.title = sf.getTitle();
        this.link = sf.getLink();
        this.description = sf.getDescription();
        this.publishedDate = sf.getPublishedDate();

        this.authors = new ArrayList<>();
        if (sf.getAuthors() != null) {
            for (SyndPerson person : sf.getAuthors()) {
                this.authors.add(person.getName());
            }
        }

        this.contributors = new ArrayList<>();
        if (sf.getContributors() != null) {
            for (SyndPerson person : sf.getContributors()) {
                this.contributors.add(person.getName());
            }
        }

        this.copyright = sf.getCopyright();

        if (sf.getImage() != null) {
            this.imageUrl = sf.getImage().getUrl();
        }

        this.categories = new ArrayList<>();
        for (SyndCategory category : sf.getCategories()) {
            this.categories.add(category.getName());
        }

        this.entries = new ArrayList<>();
        for (SyndEntry entry : sf.getEntries()) {
            this.entries.add(new Entry(entry));
        }

        this.language = sf.getLanguage();
        this.webMaster = sf.getWebMaster();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getContributors() {
        return contributors;
    }

    public void setContributors(List<String> contributors) {
        this.contributors = contributors;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWebMaster() {
        return webMaster;
    }

    public void setWebMaster(String webMaster) {
        this.webMaster = webMaster;
    }
}
