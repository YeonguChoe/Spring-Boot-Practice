import React from 'react';
import {useParams} from "react-router-dom";

function ModifyPage(props) {

    // url에서 페이지 번호를 가져온다.
    const {tno} = useParams()

    return (
        <div className={"text-3xl font-extrabold"}>
            Todo modify page {tno}
        </div>
    );
}

export default ModifyPage;