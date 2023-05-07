package org.a402.deployz.domain.item.response;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.a402.deployz.domain.item.entity.Item;

import lombok.Getter;

@Getter
public class ItemListResponse {
	@NotNull
	private Long idx;
	@NotNull
	private String name;
	@NotNull
	private Long portNumber1;
	@NotNull
	private Long portNumber2;
	@NotNull
	private String framworkType;

	//아이템 초기 생성 시 -> 널 값이 들어갈 수 밖에 없음
	private LocalDateTime lastSuccessDate;
	private LocalDateTime lastFailureDate;
	private String status;

	@NotNull
	private String projectName;

	public ItemListResponse(Item item, String status,String projectName){
		this.idx=item.getIdx();
		this.framworkType=item.getFrameworkType();
		this.name=item.getName();
		this.portNumber1=item.getPortNumber1();
		this.portNumber2=item.getPortNumber2();
		this.lastSuccessDate=item.getLastSuccessDate();
		this.lastFailureDate=item.getLastFailureDate();
		this.status=status;
		this.projectName=projectName;
	}

}
