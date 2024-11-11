"use client";

import { Button } from "@/components/ui/button";
import React, { useEffect, useState } from "react";

function Page() {
  const [vantagem, setVantagem] = useState({
    descricao: "",
    custoMoedas: 0,
    foto: "",
    idEmpresaParceira: 0,
  });
  const [empresas, setEmpresas] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8081/empresa-parceira")
      .then((res) => res.json())
      .then((data) => setEmpresas(data))
      .catch((err) => console.error(err));
  }, []);

  function handleChange(event) {
    const { name, value } = event.target;
    setVantagem((vantagem) => ({ ...vantagem, [name]: value }));
  }

  function handleSubmit(event) {
    event.preventDefault();

    if (vantagem.descricao === "") {
      alert("Digite a descrição da vantagem");
      return;
    }

    if (vantagem.custoMoedas === 0) {
      alert("A vantagem não pode ser gratuita");
      return;
    }

    if (vantagem.idEmpresaParceira === 0) {
      alert("Selecione uma empresa parceira");
      return;
    }

    fetch("http://localhost:8081/vantagem", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(vantagem),
    })
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((error) => console.error(error));

    window.location.href = "/empresa-parceira";
  }

  return (
    <div className="m-0 md:m-auto w-[100vw] md:w-[75%] h-full p-4 md:p-0 md:pt-4">
      <h1 className="text-2xl">Criar Vantagem</h1>
      <form
        className="mt-4 w-full bg-slate-100 p-2 border-0 rounded-md grid grid-cols-1 gap-4"
        onSubmit={handleSubmit}
      >
        <label>
          Descrição:
          <input
            className="p-2 border border-gray-300 rounded w-full"
            type="text"
            name="descricao"
            value={vantagem.descricao}
            onChange={handleChange}
          />
        </label>
        <label>
          Custo em Moedas
          <input
            className="p-2 border border-gray-300 rounded w-full"
            type="number"
            name="custoMoedas"
            value={vantagem.custoMoedas}
            onChange={handleChange}
          />
        </label>
        <label>
          Foto:
          <input
            className="p-2 border border-gray-300 rounded w-full"
            type="text"
            name="foto"
            value={vantagem.foto}
            onChange={handleChange}
          />
        </label>
        <label>
          Id da Empresa Parceira:
          <select
            className="p-2 border border-gray-300 rounded w-full"
            name="idEmpresaParceira"
            value={vantagem.idEmpresaParceira}
            onChange={handleChange}
          >
            <option value="">Selecione uma empresa parceira</option>
            {empresas.map((empresa) => (
              <option key={empresa.id} value={empresa.id}>
                {empresa.nome}
              </option>
            ))}
          </select>
        </label>
        <Button type="submit">Criar Vantagem</Button>
      </form>
    </div>
  );
}

export default Page;
