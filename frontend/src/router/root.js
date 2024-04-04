import {createBrowserRouter} from "react-router-dom";
import {Suspense, lazy} from "react";
import todoRouter from "./todoRouter";

const Loading = <div className={"text-5xl"}>Loading...</div>

// Main Page에 대한 느린 컴포넌트를 만든다.
const Main = lazy(
    function () {
        return (import("../pages/MainPage"));
    }
)

// About Page에 대한 느린 컴포넌트를 만든다.
const About = lazy(
    function () {
        return (import("../pages/AboutPage"));
    }
)

const TodoIndex = lazy(() => import("../pages/todo/indexPage"))

const TodoList = lazy(() => import("../pages/todo/ListPage"))

// 접속하는 URL의 path에 따라 다른 페이지를 보여준다.
// 라우터가 리액트에서 여러 페이지를 전환해 줄수 있게 한다.
const root = createBrowserRouter([
    {
        // 기본 URL로 들어왔을때 보여주는 페이지
        path: '',
        element: (
            // fallback이 먼저 실행되고 그 다음에 Main이 실행 되게 만든다.
            <Suspense fallback={Loading}>
                <Main/>
            </Suspense>
        )
    },
    {
        // /about으로 접속 했을때 리액트 라우터가 보여주는 페이지
        path: 'about',
        element:
            (
                <Suspense fallback={Loading}>
                    <About/>
                </Suspense>
            )
    },
    {
        path: "todo",
        element: <Suspense fallback={Loading}><TodoIndex/></Suspense>,
        children: todoRouter()
    },
]);

export default root;