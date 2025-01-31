import axios from 'axios';
import { API_ROOT } from "@/config/development";
import { ToDo } from '@/model/todo';

// Ruft alle ToDo-Elemente vonder API ab
export async function getAllToDos(): Promise<ToDo[]>   { 
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.get(API_ROOT + '/api/todo', config);
        return response.data;
    } catch (error) {
        return <any>error;   
    }
}

// Fügt ein neues ToDo-Element zur API hinzu
export async function addNewToDo(newToDo: ToDo): Promise<any>   {
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.post(API_ROOT + '/api/todo', newToDo, config);
        return response.data;
    } catch (error) {
        return error;   
    }
}

// Aktualisiert ein vorhandenes ToDo-Element
export async function updateToDo(toDo: ToDo): Promise<any>   {
    const config = {        
        withCredentials: true
    }
    try {
        const response = await axios.put(API_ROOT + '/api/todo', toDo, config);
        return response.data;
    } catch (error) {
        return error;   
    }
}