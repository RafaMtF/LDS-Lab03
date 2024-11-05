"use client";

import Navigation from "@/app/components/BtnGoBack";
import Navigator from "@/app/components/BtnGoBack";
import React, { useEffect, useState } from "react";

function page(props) {
  const [aluno, setAluno] = useState({});
  const [extratos, setExtratos] = useState([]);

  const id = props.params.id;

  useEffect(() => {
    fetch(`http://localhost:8081/aluno/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setAluno(data);
      });
  }, [id]);

  useEffect(() => {
    fetch(`http://localhost:8081/api/extrato/aluno/${id}`)
      .then((res) => res.json())
      .then((data) => {
        setExtratos(data);
      });
  }, )

  return (
    <div className="w-[65vw] h-[100vh] center m-auto mt-4">
      <h1 className="text-4xl font-bold">Extrato</h1>
      <div className="mt-4">
        <h2 className="text-2xl font-semibold">Nome:</h2>
        <p className="text-lg">{aluno.nome}</p>
      </div>
      
    </div>
  );
}

export default page;
