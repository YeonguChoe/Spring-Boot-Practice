import {lazy, Suspense} from "react";
import {Navigate} from "react-router-dom";
import ModifyPage from "../pages/todo/ModifyPage";

const Loading = <div className={"text-5xl"}>Loading...</div>
const TodoList = lazy(() => import("../pages/todo/ListPage"))
const TodoRead = lazy(() => import("../pages/todo/ReadPage"))
const TodoAdd = lazy(() => import("../pages/todo/AddPage"))
const TodoModify = lazy(() => import("../pages/todo/ModifyPage"))

// todo 다음에 children을 반환하는 함수
const todoRouter = () => {

    return [
        {
            path: '',
            // todo다음에 아무것도 입력 안해도 redirect된다
            element: <Navigate replace={true} to={"list"}/>
        },
        {
            // todo/list인 경우
            path: 'list',
            element: <Suspense fallback={Loading}><TodoList/></Suspense>
        },
        {
            path: 'read',
            element: <Suspense fallback={Loading}><TodoRead/></Suspense>
        },
        {
            path: 'read/:tno',
            element: <Suspense fallback={Loading}><TodoRead/></Suspense>
        },
        {
            path: 'add',
            element: <Suspense fallback={Loading}><TodoAdd/></Suspense>
        },
        {
            path: 'modify/:tno',
            element: <Suspense fallback={Loading}><ModifyPage/></Suspense>
        }
    ]
}

export default todoRouter