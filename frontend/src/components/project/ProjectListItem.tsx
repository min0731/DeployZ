//import css
import styled from "styled-components";
import { theme } from "@/styles/theme";

//import icons
import CheckCircleOutlineIcon from "@mui/icons-material/CheckCircleOutline";
import HighlightOffIcon from "@mui/icons-material/HighlightOff";

//import components and api
import { projectListInfo } from "@/types/project";
import { changeTime } from "@/api/projectApi";
import BuildChart from "./Chart/BuildChart";

export default function ProjectListItem({
  project,
}: {
  project: projectListInfo;
}) {
  return (
    <SProjectList>
      <STitleDiv>
        <STitle>{project.projectName}</STitle>
        {project.status === "SUCCESS" ? (
          <CheckCircleOutlineIcon style={checkStyle} />
        ) : (
          <HighlightOffIcon style={HighlightOffIconStyle} />
        )}
      </STitleDiv>
      <SDesc>{project.projectDesc}</SDesc>
      <SChartDiv>
        <BuildChart itemBuildData={project.itemBuildCnt} />
      </SChartDiv>
      <STimeContainer>
        <STimeDiv>
          <SSItem>최근 빌드 성공</SSItem>
          <STimeItem>{changeTime(project.lastSuccessDate)}</STimeItem>
        </STimeDiv>
        <STimeDiv>
          <SSItem>최근 빌드 실패</SSItem>
          <STimeItem>{changeTime(project.lastFailureDate)}</STimeItem>
        </STimeDiv>
      </STimeContainer>
    </SProjectList>
  );
}

const STimeContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  gap: 5rem;
`;

const STimeDiv = styled.div`
  flex: 1;
`;

const SChartDiv = styled.div`
  width: 28rem;
  height: 18rem;
  font-size: 5rem;
  margin-left: 2rem;
`;

const STitleDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: start;
  margin-left: 2rem;
  margin-top: 1rem;
  margin-bottom: 1rem;
  gap: 1rem;
`;

const STitle = styled.div`
  font-size: 5rem;
  font-weight: ${theme.fontWeight.extraBold};
  color: ${theme.colors.primary};
`;

const SSItem = styled.span`
  font-size: 2rem;
  font-weight: ${theme.fontWeight.medium};
  color: ${theme.colors.primary};
`;

const STimeItem = styled.div`
  font-size: 2.5rem;
  font-weight: ${theme.fontWeight.extraBold};
  color: ${theme.colors.primary};
  margin-top: 0.5rem;
`;

const SDesc = styled.div`
  font-size: 2.2rem;
  font-weight: ${theme.fontWeight.medium};
  color: ${theme.colors.primary};
  margin-left: 2rem;
`;

const SProjectList = styled.div`
  width: 26vw;
  height: 37vh;
  background: ${theme.colors.lightgray};
  border-radius: 1rem;
  margin-right: 2rem;
  margin-left: 2rem;
  padding: 2rem;
`;

const HighlightOffIconStyle = {
  fontSize: "5rem",
  color: theme.colors.error,
};

const checkStyle = {
  fontSize: "5rem",
  color: theme.colors.checkgreen,
};
