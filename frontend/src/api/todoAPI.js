import axios from "axios"

// 스프링 서버와 연결
export const API_SERVER_HOST = 'http://localhost:8080'

const prefix = `${API_SERVER_HOST}/api/todo`

// 1개의 레코드만 가져온다.
export const getOne = async (tno) => {
    const res = await axios.get(`${prefix}/${tno}`);
    return res.data;
};

export const getList = async (pageParam) => {
    const { page, size } = pageParam
    // params 는 쿼리 스트링이다.
    const res = await axios.get(`${prefix}/list`, { params: { page: page, size: size } })
    return res.data
}