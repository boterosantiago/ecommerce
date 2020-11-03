import Cookies from 'universal-cookie';

const cookies = new Cookies();

const SaveCookie = (key, data) => {
    let segundos = 3600; //1 hora
    cookies.set(key, data, {
        path: '/',
        expires: new Date(Date.now() + (segundos*1000)) //en 1 hora de inactividad se elimina la cookie
    });
}

const LoadCookie = (key) => {
    return cookies.get(key);
}

const DeleteCookie = (key) => {
    cookies.remove(key);
}

export { SaveCookie, LoadCookie, DeleteCookie };