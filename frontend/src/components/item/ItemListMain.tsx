import { useState, useEffect } from "react";
import { useRecoilValue } from "recoil";
import { projectIdxState } from "@/recoil/project";

import ItemList from "@components/item/ItemList";
import { projectDetailInfo } from "@/types/project";
import { fetchProjectDetail } from "@/api/projectApi";

//import css
import styled from "styled-components";
import { theme } from "@/styles/theme";

export default function ItemListMain() {
  const projectIdx = useRecoilValue(projectIdxState);
  const [projectDetail, setProjectDetail] = useState<projectDetailInfo[]>();

  useEffect(() => {
    if (projectIdx === 0) {
    } else {
      async function fetchItems(projectIdx: number) {
        try {
          const {
            data: { result },
          } = await fetchProjectDetail(projectIdx);
          setProjectDetail(result);
        } catch (error) {
          console.error(error);
        }
      }
      fetchItems(projectIdx);
    }
  }, [projectIdx]);

  return (
    <>
      {projectIdx === 0 ? (
        <SListBox>
          <SItem>프로젝트를 클릭해주세요</SItem>
        </SListBox>
      ) : (
        <SListBox>
          <SListTitleDiv>
            <SItem></SItem>
            <SItem></SItem>
            <SItem>이름</SItem>
            <SItem>상태</SItem>
            <SItem>포트</SItem>
            <SItem>최근 성공</SItem>
            <SItem>최근 실패</SItem>
            <SItem></SItem>
            <SItem></SItem>
          </SListTitleDiv>
          <ItemList projectIdx={projectIdx} projectDetail={projectDetail} />
        </SListBox>
      )}
    </>
  );
}

const SItem = styled.div`
  flex: 2;
  font-size: 2.5rem;
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.primary};
`;

const SListBox = styled.div`
  width: 85vw;
  height: 42vh;
  background-color: ${theme.colors.white};
  border-radius: 1rem;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 1rem;
`;

const SListTitleDiv = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  width: 78vw;
  height: 10vh;
`;
