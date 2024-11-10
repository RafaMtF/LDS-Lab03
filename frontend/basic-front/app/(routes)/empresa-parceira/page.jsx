"use client";

import Image from "next/image";
import { useEffect, useState } from "react";

function Page() {
  const [empresa, setEmpresa] = useState();

  useEffect(() => {
    fetch("http://localhost:8081/empresa-parceira/1")
      .then((response) => response.json())
      .then((data) => setEmpresa(data))
      .catch((error) => console.error(error));
  }, []);

  return (
    <div className="m-0 md:m-auto w-[100vw] md:w-[75%] h-full p-4 md:p-0 md:pt-4">
      <h1 className="text-2xl">Vantagens criadas</h1>
      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {empresa?.vantagens.map((vantagem) => {
          return (
            <div
              key={vantagem.id}
              className="border-0 rounded p-4 my-4 bg-slate-100"
            >
              <Image
                src={vantagem.foto}
                alt="Foto vantagem"
                width={250}
                height={75}
              />
              <div className="flex justify-between mt-4">
                <p>{vantagem.descricao}</p>
                <p>{vantagem.custoMoedas} moedas</p>
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
}

export default Page;
