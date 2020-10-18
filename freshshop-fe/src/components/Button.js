import styled from 'styled-components';

export const ButtonCartContainer = styled.button`
    text-transform: capitalize;
    font-size: 1.8rem;
    background: transparent;
    border: 0.5rem solid;
    color: var(--mainGreen);
    border-radius: 0.5rem;
    padding: 0.2rem 0.5rem;
    cursor: pointer;
    nargin: 0.2rem 0.5rem 0.2rem 0;
    &:hover {
        background: var(--mainWhite);
        color: var(--mainGreen);
    }
    &:focus {
        outline: none;
    }
`;

export const ButtonProductContainer = styled.button`
    font-size: 1.8rem;
    background: transparent;
    color: var(--mainGreen);
    border: none;
    &:hover {
        background: var(--mainWhite);
        color: var(--mainGreen);
    }
    &:focus {
        outline: none;
    }
`;