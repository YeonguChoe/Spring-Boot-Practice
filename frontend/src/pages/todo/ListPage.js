import React from 'react';
import {useSearchParams} from "react-router-dom";
import ListComponent from "../../components/todo/ListComponent";

function ListPage(props) {

    // url 주소창에서 쿼리문을 받아오는 리액트 라우터 함수 선언
    const [queryParams] = useSearchParams()

    // url로 부터 페이지 쿼리를 반환하는 함수
    function page() {
        if (queryParams.get('page')) {
            return parseInt(queryParams.get('page'));
        } else {
            return 1;
        }
    }

    // url로 부터 쿼리 사이즈를 반환하는 함수
    const size = queryParams.get('size') ? parseInt(queryParams.get('size')) : 1

    return (
        <div className={"p-4 w-full bg-white"}>
            <div className={"text-3xl font-extrabold"}>
                Todo List Page Component ----{page()} ----{size}
            </div>
            <ListComponent/>
        </div>
    )
}

export default ListPage;