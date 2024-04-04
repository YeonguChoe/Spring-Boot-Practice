import React from 'react';
import {Link} from "react-router-dom";
import BasicLayout from "../Layouts/BasicLayout";

// Main Page에 대한 리액트 컴포넌트
function MainPage(props) {
    return (
        <BasicLayout>
            <div className={'text-2xl md:text-4xl sm:text-xl'}>
                <div>Main Page</div>
            </div>
        </BasicLayout>
    );
}

export default MainPage;