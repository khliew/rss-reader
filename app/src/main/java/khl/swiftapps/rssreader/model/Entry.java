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
import com.rometools.rome.feed.synd.SyndLink;
import com.rometools.rome.feed.synd.SyndPerson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Entry {
    private String uri;
    private String title;
    private List<String> links;
    private String description;
    private Date publishedDate;
    private Date updatedDate;
    private List<String> authors;
    private List<String> contributors;
    private List<String> categories;
    private String commentsUrl;

    public Entry() {
        // do nothing
    }

    public Entry(SyndEntry se) {
        this.uri = se.getUri();
        this.title = se.getTitle();

        this.links = new ArrayList<>();
        if (se.getLinks() != null) {
            for (SyndLink link : se.getLinks()) {
                this.links.add(link.getHref());
            }
        }

        if (se.getDescription() != null) {
            this.description = se.getDescription().getValue();
        }
        this.publishedDate = se.getPublishedDate();
        this.updatedDate = se.getUpdatedDate();

        this.authors = new ArrayList<>();
        if (se.getAuthors() != null) {
            for (SyndPerson person : se.getAuthors()) {
                this.authors.add(person.getName());
            }
        }

        this.contributors = new ArrayList<>();
        if (se.getContributors() != null) {
            for (SyndPerson person : se.getContributors()) {
                this.contributors.add(person.getName());
            }
        }

        this.categories = new ArrayList<>();
        for (SyndCategory category : se.getCategories()) {
            this.categories.add(category.getName());
        }

        this.commentsUrl = se.getComments();
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

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getCommentsUrl() {
        return commentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }
}
