"use client";

import CardVantagem from "@/components/CardVantagem";
import { useEffect, useState } from "react";

function Page() {
  const [vantagens, setVantagens] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/vantagem")
      .then((response) => response.json())
      .then((data) => {
        console.log("Fetched data:", data);
        setVantagens(Array.isArray(data) ? data : []);
      })
      .catch((error) => console.error(error));
  }, []);

  return (
    <div className="m-0 md:m-auto w-[100vw] md:w-[75%] h-full p-4 md:p-0 md:pt-4">
      <h1 className="text-2xl">Vantagens disponíveis</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {vantagens.map((vantagem) => {
          <CardVantagem key={vantagem.id} vantagem={vantagem} />;
        }) || <p>Nenhuma vantagem cadastrada</p>}
      </div>
    </div>
  );
}

export default Page;
