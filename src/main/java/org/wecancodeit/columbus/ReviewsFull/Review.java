package org.wecancodeit.columbus.ReviewsFull;

import java.util.Collection;
import java.util.HashSet;
import static java.util.Arrays.asList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String imageUrl;

	@Lob
	private String content;
	private String firstRelease;
	private String lastRelease;
	private String youTubeUrl;
	private String footerUrl;
	private String membersPic;

	@ManyToOne
	private Category category;

	@ManyToMany
	private Collection<Tag> tags;

	public Collection<Tag> getTags() {
		return tags;
	}

	public Category getCategory() {
		return category;
	}

	public String getContent() {
		return content;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getFirstRelease() {
		return firstRelease;
	}

	public String getLastRelease() {
		return lastRelease;
	}

	public String getYouTubeUrl() {
		return youTubeUrl;
	}

	public String getFooterUrl() {
		return footerUrl;
	}

	public String getMembersPic() {
		return membersPic;
	}

	public Review(String name, String imageUrl, Category category, String content, String footerUrl,
			String firstRelease, String lastRelease, String youTubeUrl, String membersPic, Tag... tags) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.category = category;
		this.content = content;
		this.footerUrl = footerUrl;
		this.firstRelease = firstRelease;
		this.lastRelease = lastRelease;
		this.youTubeUrl = youTubeUrl;
		this.membersPic = membersPic;
		this.tags = new HashSet<>(asList(tags));

	}

	@SuppressWarnings("unused")
	private Review() {

	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		return id == ((Review) obj).id;
	}

}
