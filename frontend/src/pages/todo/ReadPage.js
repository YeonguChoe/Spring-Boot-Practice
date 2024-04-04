import React from 'react';
import { createSearchParams, useNavigate, useParams, useSearchParams } from "react-router-dom";
import ReadComponent from "../../components/todo/ReadComponent";

function ReadPage(props) {

    // useParams는 경로 parameter인 tno를 받는다
    const { tno } = useParams();
    // 다른 링크로 이동을 시켜주는 함수
    const navigate = useNavigate();

    // query parameter를 받아오는 함수
    const [queryParams] = useSearchParams()

    // 페이지와 사이즈를 받아오고 int로 변환한다
    const page = queryParams.get('page') ? parseInt(queryParams.get('page')) : 1;
    const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 1;

    // query string을 만들어주는 함수
    const queryStr = createSearchParams({ page: page, size: size }).toString();

    console.log(queryStr)

    const moveToModify = (tno) => {
        navigate({
            pathname: `/todo/modify/${tno}`,
            search: queryStr
        })
    }

    const moveToList = () => {
        navigate({
            pathname: '/todo/List',
            search: queryStr
        })
    }

    return (

        <div className={"text-3xl"}>
            Todo Read Page {tno}

            <div>
                <ReadComponent tno={tno} />
                <button className={"bg-blue-500 rounded-full px-5 py-3"} onClick={() => moveToModify(tno)}>Test Modify
                </button>
                <button className={"bg-blue-500 rounded-full px-5 py-3"} onClick={() => moveToList()}>Test List</button>
            </div>
        </div>
    );
}

export default ReadPage;