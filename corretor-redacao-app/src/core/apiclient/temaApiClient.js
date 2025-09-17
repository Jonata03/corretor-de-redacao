import axios from "axios";

class temaApiClient {

    async buscarTemas() {
        console.log("Buscando temas...");
        return await axios.get('/api/temas');
    }

}

export default new temaApiClient()