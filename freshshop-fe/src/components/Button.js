import styled from 'styled-components';

export const ButtonCartContainer = styled.button`
    text-transform: capitalize;
    font-size: 1.8rem;
    background: transparent;
    border: 0.5rem solid;
    border-color: ${props => props.cart? "var(--mainYellow)" : "var(--lightBlue)"}
    color: ${props => props.cart? "var(--mainYellow)" : "var(--lightBlue)"};
    border-radius: 0.5rem;
    padding: 0.2rem 0.5rem;
    cursor: pointer;
    nargin: 0.2rem 0.5rem 0.2rem 0;
    &:hover {
        background: ${props => props.cart? "var(--mainYellow)" : "var(--lightBlue)"};
        color: var(--mainGreen);
    }
    &:focus {
        outline: none;
    }
`;

export const DefaultNavButtonContainer = styled.button`
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