import './App.css';
import {RouterProvider} from "react-router-dom";
import root from './router/root'

function App() {
    // 리액트 라우터를 붙여준다.
    return (
        <RouterProvider router={root}/>
    );
}

export default App;
