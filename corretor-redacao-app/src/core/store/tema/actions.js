import {actionTypes} from "@/core/constants";
import api from "@/core/apiclient/index.js";

export default {

    async [actionTypes.TEMA.BUSCAR_TEMAS](context) {
        const {data} = await api.tema.buscarTemas();
        return data;
    }
}