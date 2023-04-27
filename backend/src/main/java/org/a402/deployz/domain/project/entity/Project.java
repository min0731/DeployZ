package org.a402.deployz.domain.project.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.a402.deployz.domain.git.entity.GitConfig;
import org.a402.deployz.domain.member.entity.Member;
import org.a402.deployz.domain.project.entity.Item;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idx", nullable = false)
	private Long idx;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_idx")
	private Member member;
	@Column(name = "deleted_flag", nullable = false)
	private boolean deletedFlag;
	@Column(name = "project_name", length = 50)
	private String projectName;
	@Column(name = "last_success_date")
	private LocalDateTime lastSuccessDate;
	@Column(name = "last_modified_date")
	private LocalDateTime lastModifiedDate;
	@Column(name = "description", length = 100)
	private String description;
	@Column(name = "image_path", length = 100)
	private String imagePath;
	@OneToMany(mappedBy = "project", orphanRemoval = true, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Item> items = new ArrayList<>();
	@OneToOne
	@JoinColumn(name = "git_config_idx")
	private GitConfig gitConfig;
	@OneToOne
	@JoinColumn(name = "nginx_config_idx")
	private NginxConfig nginxConfig;

	@Builder
	public Project(Long idx, Member member, boolean deletedFlag, String projectName, LocalDateTime lastSuccessDate, LocalDateTime lastModifiedDate, String description, String imagePath, List<Item> items, GitConfig gitConfig, NginxConfig nginxConfig) {
		this.idx = idx;
		this.member = member;
		this.deletedFlag = deletedFlag;
		this.projectName = projectName;
		this.lastSuccessDate = lastSuccessDate;
		this.lastModifiedDate = lastModifiedDate;
		this.description = description;
		this.imagePath = imagePath;
		this.items = items;
		this.gitConfig = gitConfig;
		this.nginxConfig = nginxConfig;
	}
}
