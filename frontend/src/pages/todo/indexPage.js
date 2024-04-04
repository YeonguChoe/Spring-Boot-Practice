import React, {useCallback} from 'react';
import BasicLayout from "../../Layouts/BasicLayout";
import {Outlet, useNavigate} from "react-router-dom";


function IndexPage(props) {

    // useNavigate를 사용하면 Link태그와 같은 역할을 할 수 있다
    const navigate = useNavigate()

    // 성능 향상을 위해 memoization을 사용하는 useCallback 사용
    const handleClickList = useCallback(() => {
        navigate({pathname: 'list'})
    }, [])

    // 성능 향상을 위해 memoization을 사용하는 useCallback 사용
    const handleClickAdd = useCallback(() => {
        navigate({pathname: 'add'})
    }, [])


    return (
        <BasicLayout>
            <div className={"w-full flex m-2 p-2"}>
                <div className={"text-xl m-1 p-2 w-20 font-extrabold text-center underline"}
                     onClick={handleClickList}>LIST
                </div>
                <div className={"text-xl m-1 p-2 w-20 font-extrabold text-center underline"}
                     onClick={handleClickAdd}>ADD
                </div>
            </div>
            <div className={"flex flex-wrap w-full"}>
                <Outlet/>
            </div>
        </BasicLayout>
    );
}

export default IndexPage;